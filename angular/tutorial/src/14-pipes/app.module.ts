import { NgModule } from "@angular/core";
import { ReactiveFormsModule } from "@angular/forms";
import { BrowserModule } from "@angular/platform-browser";
import { AppComponent } from "./app.component";
import { CapitalizePipe } from './capitalize.pipe';


@NgModule({
  declarations: [AppComponent, CapitalizePipe], // comp, direct, pipe
  imports: [BrowserModule], // other modules (app)
  bootstrap: [AppComponent]

})
export class AppModule{}

