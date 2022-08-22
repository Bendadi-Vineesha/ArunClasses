import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'capitalize'
})
export class CapitalizePipe implements PipeTransform {

  transform(value: string, args: boolean=false): string {

    if(args==false){
      return this.capitalizeWord(value);
    } else {
      return value.split(" ").map(word=>this.capitalizeWord(word)).join(" ")
    }

  }

  capitalizeWord(word:string){
    return word.charAt(0).toUpperCase()+word.substring(1).toLowerCase();
  }

}
