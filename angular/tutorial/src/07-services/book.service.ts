import { Injectable } from "@angular/core";


// @Component, @Service, @Controller, @Configuration - spring
@Injectable({
    providedIn: "root"
})
export class BookService {

    comicBooks = [{
        title: "Wonder Woman",
        rating: 4.7,
        releasedYear: 2017 
    }]

    

}


/*

// to inject
providers: [BookService]


// to consume
@Autowired
BookService service;

constructor(private service:BookService){}
*/