# Angular Nots

## Notes
* Starting file
    * app.module.ts
* Angular Application == Component1 + Component2 + Service1 + Service2
	* Angular application set of components
	* Set of services provides functionality across components
* Angular Component
	* View - Template, HTML for user interface
	* class, code associated with view
		* properties
		* Methods
	* Metadata
* Angular module
	* Organize application into blocks
	* Every angular application has atlease one angular module called `Root Angular Module`

## Angular 2 language choices
* ES5 (ECMAScript5)
    * No compilation is needed
* ES6/ES2015
* TypeScript
* Dart
    * This is not javascript
    * Lowest adopted than above 2

## What is TypeScript
* Open source language
* Superset of Javascript
* Transpile to plain Javascript
* Strongly typed
	* TypeScript type definition files (*.d.ts)
* class based object orientation

## Directives
* ngFor, ngIf
* These are call **Structural Directives** because they change the structure of DOM
    * Structural directives have prefix - *
    ```
    *ngFor, *ngIf
    ```
* `ngFor`
	* for-of will get object. Below code prints `jack, jill, jane ..`
```
let employee of employees
```
	* for-in will get index. Below code prints - `0,1,2..`. **in** is iterating index
```
let employee in employees
```

## Data Binding
* Interpolation
    * Component to DOM
```
{{emp.name}}
```
* One Way Binding
    * Component to DOM
```
<h4 [innerText]="emp.name"></h4>
```
* Event Binding
```
<button (click)="buttonClick('jack')" (blur)="buttonBlur("jill")">Send</button>
```
* Two Way Binding
```
<input [(ngModel)]="story.name" />
```

## Services
* We define class and write business logic

## Decorator
* Start with symbol `@`
* Component decorator
```
import { Component } from '@angular/core';

@Component({
  selector: 'pm-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
```
* NgModule decorator
```
import { NgModule } from '@angular/core';

@NgModule({
  declarations: [ AppComponent ],
  imports: [ BrowserModule, AppRoutingModule ],
  providers: [],
  bootstrap: [AppComponent]
})
```

## Steps to create new project in angular
* Install node
* Install npm
* Install angular cli
* Run below command to create new project named `product-management`
```
ng new product-management
```
* Open project in visual studio once created
* Open `package.json` change `scripts/start` key value from `ng serve` to `ng serve -o`
* Run application
```
npm start
```
* Browser open automatically with url `http://localhost:4200`

## Intall bootstrap
* Run below command from project root directory
```
npm install bootstrap
```

## Intall font-awesome
* Run below command from project root directory
```
npm install font-awesome
```

## Enable bootstrap and font-awesome
* Open `style.css`
* Add below entries
```
@import "~bootstrap/dist/css/bootstrap.min.css";
@import "~font-awesome/css/font-awesome.min.css";
```

## Component level styles
* Declare `styles` property in `@Component` directive
```
@Component({
	selector: 'emps',
	template: './employee.component.html',
	styles: ['thead {color: red;}']
})
```
* Declare 'styleUrls` property in `@Component` directive. We can pass multiple css files
```
@Component({
	selector: 'emps',
	template: './employee.component.html',
	styleUrls: ['./employees1.component.css', './employees2.component.css']
})
```

## Component Lifecycle
* Lifecycle steps
	* Create
	* Render
	* Create and render children
	* Process changes
	* Destroy
* Angular provide life cycle hooks to perform operations at any of the above steps
* Lifecycle hooks
	* OnInit: Perform component initialization after angular initializes data bound properties. This is good place to retrieve data from backend server through rest api
	* OnChanges: Perform any action after changes to input properties
	* OnDestroy: To perform any clean up before angular destroys component
* Each life cycle interface declares one method with syntax `ng[InterfaceName]`	

### OnInit lifecycle hook
* Implment `OnInit` interface
```
import { Component, OnInit } from '@angular/core';

export class EmployeeComponent implements OnInit{
	id: number;
	name: string;
	
	ngOnInit(): void {
		console.log('In OnInit');
	}
}
```

# Install Angular Material UI Design to Angular application
* Refer [Angular Material UI](https://material.angular.io/)
* Install using npm. If angular cli version < 6
```
npm install --save @angular/material
```
* If angular cli version > 6
```
ng add @angular/material
```