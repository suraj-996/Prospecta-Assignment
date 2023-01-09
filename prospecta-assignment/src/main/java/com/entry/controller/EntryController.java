package com.entry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.entry.model.Data;
import com.entry.model.Entry;
import com.entry.model.EntryDto;
import com.entry.repository.EntryRepository;

@RestController
public class EntryController {
	
//	@Autowired
//	private EntryService entryService;
//	
//	@GetMapping("/entries/{category}")
//	public ResponseEntity<List<EntryDto>> getEntriesController(@PathVariable("category") String category){
//		List<EntryDto> lists=entryService.getEntries(category);
//		return new ResponseEntity<List<EntryDto>>(lists,HttpStatus.OK);
//	}
//	
//	@PostMapping("/entries")
//	public ResponseEntity<Entry> saveEntryController(@RequestBody EntryDto entryDto) {
//		Entry entry=entryService.saveEntry(entryDto);
//		return new ResponseEntity<Entry>(entry,HttpStatus.OK);
//	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private EntryRepository entryRepo;
	
	@GetMapping("/entries/{category}")
	public ResponseEntity<List<EntryDto>> getEntriesHandler(@PathVariable("category") String category){
		
		
		Data d= restTemplate.getForObject("https://api.publicapis.org/entries", Data.class);
		
		List<Entry> entries= d.getEntries();
		List<EntryDto> list= entries.stream().filter(e -> e.getCategory().equalsIgnoreCase(category)).map(e -> new EntryDto(e.getApi(), e.getDescription())).toList();
		 
		return new ResponseEntity<List<EntryDto>>(list,HttpStatus.OK);
		
	}
	
	@PostMapping("/entries")
	public ResponseEntity<Entry> saveEntriesHandler(@RequestBody EntryDto resultDto) {
		
		// get the Entry object from the user, using request body
		
		Data d= restTemplate.getForObject("https://api.publicapis.org/entries", Data.class);
		Entry e=d.getEntries().get(0);
		
		Entry newEntry=new Entry(resultDto.getTitle(),resultDto.getDescription(),e.getAuth(),e.ishTTPS(),e.getCors(),e.getLink(),e.getCategory());
		Entry savedEntry=entryRepo.save(newEntry);
		return new ResponseEntity<Entry>(savedEntry,HttpStatus.OK);
	}
	
}
