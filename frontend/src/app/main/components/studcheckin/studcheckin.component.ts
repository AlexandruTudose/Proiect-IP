import { Component, OnInit } from '@angular/core';
import {Checkin} from "../../interfaces/Checkin";
import {CheckinService} from "../../services/checkin.service";

@Component({
  selector: 'ip-studcheckin',
  templateUrl: './studcheckin.component.html',
  styleUrls: ['./studcheckin.component.css']
})
export class StudcheckinComponent implements OnInit {

  check: Checkin = new Checkin();
  confirmation: any;
  userId: string;

  constructor(private checkinService: CheckinService) { }

  ngOnInit() {
    this.userId = sessionStorage.getItem("userId");
  }

  checkIn() {
    this.checkinService.joinCheckin(this.check,this.userId).subscribe(
      (response) => {
          this.confirmation = "Checkin adaugat cu succes!";
      }
    )
  }

}
