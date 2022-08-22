import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-button',
  templateUrl: './button.component.html',
  styleUrls: ['./button.component.scss']
})
export class ButtonComponent implements OnInit, OnChanges {

  @Input()
  color:string = "77, 244, 189";
  // color:string = "250, 140, 140";

  myStyle = {
        "background-color": "rgba("+this.color+", .5)",
        "border": "2px solid rgba("+this.color+", .8)",
        "box-shadow": "1px 1px 5px 1px rgba("+this.color+", 1)"
    }

  constructor() { }

  ngOnInit(): void {
  }
  ngOnChanges(changes: SimpleChanges): void {
      console.log(changes);
      this.myStyle["background-color"]="rgba("+changes["color"].currentValue+", .5)";

      this.myStyle["border"]= "2px solid rgba("+changes["color"].currentValue+", .8)";
      this.myStyle["box-shadow"]= "1px 1px 5px 1px rgba("+changes["color"].currentValue+", 1)"
  }

}
