# Typescript notes

## Interface
* Specification identifying related set of properties and methods
* class implements interface
* Use can use interface as data type
* ES5 and ES2015 do not support interface. But Typescript supports interfaces
* interfaces are traspiled and not found in resulting javascript file. This means interfaces are for development time only
* Example interface
```
export interface IPerson{
	id: number;
	name: string;
	address: string;
	birthDate: Date;
	heigh: number;
	
	calculateAge(birthDate: Date): number;
}
```
* Using the interface as data type
```
import { IPerson } from './person';

export class Employee{
	joiningDate: Date;
	details: IPerson;
	projects: String[] = [..];
	
}
```
* We can declare class in the interface ts file itself
```
export interface IPerson{
	id: number;
	name: string;
	birthDate: Date;
	
	calculateAge(): number;
}

export class Person implements IPerson{
	constructor(public id: number,
				public name: string,
				public birthDate: Date){
		}
		
		calculateAge(): number{
			// TODO logic
		}
}
```