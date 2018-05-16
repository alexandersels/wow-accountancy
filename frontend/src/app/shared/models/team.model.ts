import { Player } from './player.model';

export interface Team {

  id?: number;
  name?: string;
  memberOne?: Player;
  memberTwo?: Player;
  memberThree?: Player;
  memberFour?: Player;

}
