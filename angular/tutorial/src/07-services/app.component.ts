import { Component } from "@angular/core";
import { BookService } from "./book.service";

@Component({
    selector: "app-root",
    templateUrl: `app.component.html`,
    styleUrls: ['app.component.scss']
    // providers: [BookService]
})
export class AppComponent { 

    constructor(private service:BookService){}

    createBook(){
        let book = {title: "Superman", rating: 3.5, releasedYear: 2016}

        // where to add
        this.service.comicBooks.push(book)
    }
}