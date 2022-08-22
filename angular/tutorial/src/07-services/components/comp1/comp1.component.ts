import { Component, OnInit } from '@angular/core';
import { BookService } from './../../book.service';

@Component({
  selector: 'app-comp1',
  templateUrl: './comp1.component.html',
  styleUrls: ['./comp1.component.scss']
})
export class Comp1Component implements OnInit {

  constructor(public service:BookService) { }

  ngOnInit(): void {
    console.log(this.service.comicBooks)
  }

}
