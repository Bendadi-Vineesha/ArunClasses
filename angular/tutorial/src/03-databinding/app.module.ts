import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { AppComponent } from "./app.component";


@NgModule({
  declarations: [AppComponent], // comp, direct, pipe
  imports: [BrowserModule], // other modules (app)
  bootstrap: [AppComponent]

})
export class AppModule{}

