import { Component } from "@angular/core";
import { bindCallback } from "rxjs";

@Component({
    selector: "app-root",
    templateUrl: `app.component.html`,
    styleUrls: ['app.component.scss']
})
export class AppComponent { 

    flag:boolean = false;
    myCssClass="";
    myStyle:any = {
        color: "black"
    }

    toggle(){
        this.flag = !this.flag;

        this.toggleCss();
        this.toggleStyle();
    }

    toggleCss(){
        if(this.flag){
            this.myCssClass = "success";
        } else {
            this.myCssClass = "failure";
        }
    }

    toggleStyle(){
        if(this.flag){
            this.myStyle.color="white";
            this.myStyle["background-color"] = "blue";
            this.myStyle["text-align"] = "right";
            this.myStyle["padding"] = "10px";
            this.myStyle["border-radius"] = "10px";
        } else {
            this.myStyle.color="black";
            this.myStyle["background-color"] = "white";
            this.myStyle["text-align"] = "left";
            this.myStyle["padding"] = "0";
            this.myStyle["border-radius"] = "0";
        }
    }

}