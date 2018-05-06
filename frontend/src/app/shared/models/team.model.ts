import { Player } from './player.model';

export class Team {

  id: number;
  name: string;
  memberOne: Player;
  memberTwo: Player;
  memberThree: Player;
  memberFour: Player;

  constructor() {
    this.memberOne = new Player();
    this.memberTwo = new Player();
    this.memberThree = new Player();
    this.memberFour = new Player();
  }
}
