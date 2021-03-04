import { Component, OnInit } from '@angular/core';
import { cartService } from '../service/cartService';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {
  products:any
  constructor(private cartServiceData: cartService,private http: HttpClient){
  }
  ngOnInit(): void {
    this.products=this.cartServiceData.products
    this.http.get<any>('http://localhost:8080/').subscribe(data => {
            console.log(data)
            this.products=data;
            this.cartServiceData.products=data.results
        })
  }
   addToCart(product: any) {
     this.cartServiceData.addToCart(product)
   }
}
