import { PipeTransform } from '@angular/core';

export abstract class Sort implements PipeTransform {

  abstract transform(data: any[], sortType: string, reverse:boolean): any[];

  public compareValues(valueOne: string, valueTwo: string, reverse: boolean) : number {
    if(reverse) {
      return valueOne > valueTwo ? -1:1;
    }
    else {
      return valueOne < valueTwo ? -1:1;
    }
  }

  public compareIntValues(valueOne: number, valueTwo: number, reverse: boolean) : number {
    if(reverse) {
      return valueOne > valueTwo ? -1:1;
    }
    else {
      return valueOne < valueTwo ? -1:1;
    }
  }

  public compareDateValues(valueOne: Date, valueTwo: Date, reverse: boolean) : number {
    if(reverse) {
      return valueOne > valueTwo ? -1:1;
    }
    else {
      return valueOne < valueTwo ? -1:1;
    }
  }

}
