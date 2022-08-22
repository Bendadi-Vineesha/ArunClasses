import { NgModule } from "@angular/core";
import { ReactiveFormsModule } from "@angular/forms";
import { BrowserModule } from "@angular/platform-browser";
import { AppComponent } from "./app.component";


@NgModule({
  declarations: [AppComponent], // comp, direct, pipe
  imports: [BrowserModule, ReactiveFormsModule], // other modules (app)
  bootstrap: [AppComponent]

})
export class AppModule{}

