package com.javaworm;

import java.util.ArrayList;
import java.util.List;

import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.routing.AggregationContext;
import org.mule.routing.AggregationStrategy;

public class AggregatePayload implements AggregationStrategy {

	@Override
	public MuleEvent aggregate(AggregationContext context) throws MuleException {

		MuleEvent result = null;
		List<Object> payloadObjList = new ArrayList<Object>();

		for (MuleEvent event : context.collectEventsWithoutExceptions()) {
			Object payloadObj = event.getMessage().getPayload();
			payloadObjList.add(payloadObj);

			String response = payloadObj.toString();
			System.out.println(response);
		}

		for (MuleEvent event : context.collectEventsWithExceptions()) {

			Object payloadObj = event.getMessage().getPayload();
			payloadObjList.add(payloadObj);

			String response = payloadObj.toString();
			System.out.println(response);

			String exception = event.getMessage().getExceptionPayload().getException().toString();
			System.out.println(exception);

		}

		result = context.getOriginalEvent();
		result.getMessage().setPayload(payloadObjList);
		return result;
	}

}
