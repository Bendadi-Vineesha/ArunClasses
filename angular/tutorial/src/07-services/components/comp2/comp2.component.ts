import { Component, OnInit } from '@angular/core';
import { BookService } from './../../book.service';

@Component({
  selector: 'app-comp2',
  templateUrl: './comp2.component.html',
  styleUrls: ['./comp2.component.scss']
})
export class Comp2Component implements OnInit {

  constructor(public service:BookService) { }

  ngOnInit(): void {
  }

}
