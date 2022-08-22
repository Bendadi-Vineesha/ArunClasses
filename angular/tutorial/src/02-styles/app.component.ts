import { Component } from "@angular/core";

// component = template + logic
@Component({
    selector: "app-root",
    // template: "<h2>This is app comp</h2>"
    templateUrl: `app.component.html`,
    styleUrls: ['app.component.scss']
})
export class AppComponent { }