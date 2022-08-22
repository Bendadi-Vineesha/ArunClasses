import { Component } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";

@Component({
    selector: "app-root",
    templateUrl: `app.component.html`,
    styleUrls: ['app.component.scss']
})
export class AppComponent { 

    releasedDate1: number = Date.now();
    releasedDate2: Date = new Date(1996, 3, 20)

    books:any[] = [
        {title: "Ironman", price: 61}
    ]


    title:string = "suPerMaN is flyING";

}