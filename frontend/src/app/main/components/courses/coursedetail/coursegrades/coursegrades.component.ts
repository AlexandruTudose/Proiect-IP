import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'ip-coursegrades',
  templateUrl: './coursegrades.component.html',
  styleUrls: ['./coursegrades.component.css']
})
export class CoursegradesComponent implements OnInit {

  constructor() {
  }

  ngOnInit() {
  }

  public barChartOptions: any = {
    scaleShowVerticalLines: false,
    responsive: true
  };
  public barChartLabels: string[] = ['2006', '2007', '2008', '2009', '2010', '2011', '2012'];
  public barChartType: string = 'bar';
  public barChartLegend: boolean = true;

  public barChartData: any[] = [
    {data: [97, 59, 80, 81, 56, 55, 40], label: 'Seria A'},
    {data: [28, 48, 40, 19, 86, 96, 90], label: 'Seria B'}
  ];

  // events
  public chartClicked(e: any): void {
    // console.log(e);
  }

  public chartHovered(e: any): void {
    // console.log(e);
  }

  public randomize(): void {
    // Only Change 3 values
    let data = [
      Math.round(Math.random() * 100),
      59,
      80,
      (Math.random() * 100),
      56,
      (Math.random() * 100),
      40];
    let clone = JSON.parse(JSON.stringify(this.barChartData));
    clone[0].data = data;
    this.barChartData = clone;
  }
}
