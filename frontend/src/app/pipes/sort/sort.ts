import { PipeTransform } from '@angular/core';

export abstract class Sort implements PipeTransform {

  abstract transform(data: any[], sortType: string, reverse:boolean): any[];

  public compareValues(valueOne: any, valueTwo: any, reverse: boolean) : number {
    if(reverse) {
      return valueOne > valueTwo ? -1:1;
    }
    else {
      return valueOne < valueTwo ? -1:1;
    }
  }

}
