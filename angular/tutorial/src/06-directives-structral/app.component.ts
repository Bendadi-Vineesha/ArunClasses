import { Component } from "@angular/core";
import { Book } from "./book";

@Component({
    selector: "app-root",
    templateUrl: `app.component.html`,
    styleUrls: ['app.component.scss']
})
export class AppComponent {

    errorMessage: string = "";
    books: Array<Book> = [];

    sendRequest() {
        // bad happened
        this.errorMessage = "Error occurred";
    }

    ngOnInit() {

        setTimeout(() => {
            this.books.push(new Book("Superman is flying", "Mark", 45));
            this.books.push(new Book("Batman in a day", "John", 47));
            this.books.push(new Book("Antman is not ant", "Miley", 41));
            this.books.push(new Book("Hulk is pink now", "Tom", 39));
            this.books.push(new Book("Superman vs Spiderman", "Me", 89));
        }, 5000);

    }

}