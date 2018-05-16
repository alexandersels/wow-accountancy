import { Pipe, PipeTransform } from '@angular/core';
import { Split } from '../../shared/models/split.model';


@Pipe({
  name: 'splitFilter',
  pure: true
})
export class SplitSearchFilter implements PipeTransform {

  transform(splits: Split[], searchText: string): Split[] {

    if (!splits) return splits;
    if (!searchText) return splits;

    searchText = searchText.toLocaleLowerCase();

    return splits.filter(split => {
      return split.player.name.toLowerCase().includes(searchText)
    });
  }
}
