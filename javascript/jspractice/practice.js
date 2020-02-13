      const titleArray = [...'Test title'].entries();
      for (let title of titleArray ) {
            console.log(title);
      }

      const titleArrayIterator = 'Test title'[Symbol.iterator]();
      console.log(titleArrayIterator.next());

      console.log('Title array iterator-->', [... titleArrayIterator])

	  let iteratorObject = {
		    n1 : 1,
			n2 : 1,
            next() {
		let current = this.n2;
                this.n2 = this.n1;
                this.n1 = this.n1 + current;
                return {value: current, done: false};
            },

            return(v) {
              console.log('Done');
             return { value: v, done: true };
         }
        }

     console.log("Iterating over iterator object--> ", iteratorObject.next());

	 let iterable = {
		 [Symbol.iterator]() { return iteratorObject; }
	 }

	 let iterator = iterable[Symbol.iterator]();
      for(value of iterable) {
		  console.log(value);
		  if(value>40) break;
	  }