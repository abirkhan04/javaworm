/*
 * This Java source file was generated by the Gradle 'init' task
 */
package ReactorCoreIntroduction;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.Test;
import reactor.core.publisher.Flux;

public class ReactorCoreDemoTest {

	@Test
	public void testFluxCreation() {
		List<String> iterable = Arrays.asList("one", "two");
		Flux<String> seq = Flux.fromIterable(iterable);
		seq.map(String::toUpperCase).subscribe((item) -> System.out.println(item));
		Flux<Integer> ints = Flux.range(2, 3);
		ints.subscribe((item) -> System.out.println(item));
	}

	@Test
	public void testFluxWithError() {
		Flux<Integer> ints = Flux.range(1, 4).map(i -> {
			if (i > 3) {
				throw new RuntimeException("More than 3");
			}
			return i;
		});

		ints.subscribe((i) -> {
			System.out.println(i);
		  }, (error) -> {
			System.err.println(error);
		});
	}
	
	@Test
	public void testListeners() {
		Flux<Integer> ints = Flux.range(1, 4);
		ints.subscribe(i -> System.out.println(i),
		    error -> System.err.println("Error " + error),
		    () -> System.out.println("Done")); 
	}
	
	@Test
	public void fluxUsingGenerator() {
		Flux<String> flux = Flux.generate(()->0, (state, sink)-> {
			sink.next("3 x " + state + "=" + 3 * state);
			if(state == 10) sink.complete();
			return state + 1;
		});
		flux.subscribe((value) -> System.out.println(value));
		
		Flux<String> fluxUsingMutableS = Flux.generate(AtomicLong::new, (state, sink) -> {
			Long i = state.getAndIncrement();
			sink.next("3 x " + i + "=" + 3*i);
			if(i==10) sink.complete();
			return state;
		});
		fluxUsingMutableS.subscribe((value)-> System.out.println(value));
	}

}
