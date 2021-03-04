import { Component, OnInit } from '@angular/core';
import { cartService } from '../service/cartService';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {
  cart : any
  totalCart:any
  constructor(private cartServiceData: cartService,private http: HttpClient){
  }
  ngOnInit(): void {
    this.cart=this.cartServiceData.cart
    this.totalCart=this.cartServiceData.totalCart
    this.cartServiceData.updateResult();
  }
   deleteItem(product: any) {
     this.cartServiceData.deleteItem(product)
    this.totalCart=this.cartServiceData.totalCart
    this.cartServiceData.updateResult();
   }
   addItem(product: any) {
     this.cartServiceData.addItem(product)
    this.totalCart=this.cartServiceData.totalCart
    this.cartServiceData.updateResult();
   }
   placeOrder(){
      const headers = { 'content-type': 'application/json'}
      const body=JSON.stringify(this.cart);
      this.http.post('http://localhost:8080/update', body,{'headers':headers}).subscribe(data => {
        console.log(data);
      })
      console.log(body);
      console.log(headers);
   }
}
