import { Component, OnInit } from '@angular/core';
import { RealmService } from '../services/realm.service';
import { Realm } from '../shared/models/realm.model';

@Component({
  selector: 'app-realm-list',
  templateUrl: './realm-list.component.html',
  styleUrls: ['./realm-list.component.css']
})
export class RealmListComponent implements OnInit {

  realms: Realm[];

  constructor(private realmService: RealmService) { }

  ngOnInit() {
    this.getRealms();
  }

  getRealms(): void {
    this.realmService.getRealms().subscribe(realms => this.realms = realms);
  }

}
