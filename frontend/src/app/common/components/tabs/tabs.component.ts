import {Component, OnInit, Input} from '@angular/core';
import {Tab} from "./Tab";
import {Router} from '@angular/router';
import {TabSelected} from "./TabSelected";

@Component({
  selector: 'ip-tabs',
  templateUrl: './tabs.component.html',
  styleUrls: ['./tabs.component.css'],
})
export class TabsComponent implements OnInit {
  @Input() public selectedTab: TabSelected;
  @Input() public tabs: Array<Tab>;
  @Input() public courseId;

  selectedRow = 0;
  setClickedRow: Function;

  tabSelected(tabid,taburl) {
    this.selectedTab.select = tabid;
  }

  ngOnInit() {
  }

  constructor(private router: Router) {
    this.setClickedRow = function (index) {
      this.selectedRow = index;
    }
  }

}
