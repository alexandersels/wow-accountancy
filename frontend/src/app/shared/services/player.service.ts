import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Player } from '../models/player.model';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class PlayerService {

    constructor(private http: HttpClient)
    {

    }

    createPlayer(player: Player) : Observable<Player> {
        return this.http.put<Player>('/api/player/', player);
    }

    getPlayers() : Observable<Player[]> {
        return this.http.get<Player[]>('/api/player/');
    }

    getPlayer(name: string): Observable<Player>{
      return this.http.get<Player>('/api/player/'+ name);
    }
}
