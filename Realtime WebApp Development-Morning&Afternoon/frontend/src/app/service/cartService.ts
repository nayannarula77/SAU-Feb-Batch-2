import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})

export class cartService {
  totalCart:any
  products:any =[
    ]
  cart:any =[
    ]
  constructor(private http: HttpClient) {}
  addToCart(product:any){
    for (let x in this.cart) {
        if (this.cart.hasOwnProperty(x) && this.cart[x].itemId=== product.itemId) {
            alert("Item ALready Present in Cart!!!")
            return;
        }
    }
    this.cart.push({...product,itemsBooked:1})
    this.updateResult()
  }
     addItem(product: any) {
     this.cart.forEach((item, index) => {
      if (item.itemId== product.itemId) {
        console.log(item, product);
        if(this.cart[index].itemsBooked < item.itemQuantity)
         this.cart[index].itemsBooked++
        else
         alert(`No More ${product.itemName} Available`);
      }
    });
    this.updateResult()
  }
   deleteItem(product: any) {
     this.cart.forEach((item, index) => {
      if (item.itemId== product.itemId) {
        if(this.cart[index].itemsBooked>=1)
        this.cart[index].itemsBooked--
      }
    });
    this.updateResult()
  }
  updateResult(){
    let totalItems=0;
    let totalPrice=0;
    this.cart.forEach((item,index)=>{
        totalItems=totalItems+item.itemsBooked;
        totalPrice=totalPrice+(item.itemsBooked*item.itemPrice)
    })
    this.totalCart={
      totalPrice:totalPrice,
      totalItems:totalItems
    }
    return this.totalCart;
  }
}
