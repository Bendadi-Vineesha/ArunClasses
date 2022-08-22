import { Component } from "@angular/core";

@Component({
    selector: "app-root",
    templateUrl: `app.component.html`,
    styleUrls: ['app.component.scss']
})
export class AppComponent { 

    message:string = "dummy message";

    changeMessage(msg:string){
        this.message = msg;
    }
}