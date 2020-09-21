import { EventEmitter } from 'events'
import { Dispatcher } from 'flux'
import React from 'react';

export const Countdown = ({ count, tick, reset }) => {
    if (count) { setTimeout(() => tick(), 1000) } return (count) ?
        <h1>{count}</h1> : <div onClick={() => reset(10)}>
            <span>CELEBRATE !!!</span>
            <span>click to begin</span>
        </div>
}

export const countDownActions = dispatcher => ({
    tick(currentCount) {
        dispatcher.handleAction({ type: 'TICK' })
    },
    reset(count) {
        dispatcher.handleAction({ type: 'RESET', count })
    }
})

export class CountDownDispatcher extends Dispatcher {
    handleAction(action) {
        console.log('dispatching action: ', action)
        this.dispatch({ source: 'VIEW_ACTION', action })
    }
}


export class CountdownStore extends EventEmitter {
    constructor(count = 5, dispatcher) {
        super()
        this._count = count
        this.dispatchIndex = dispatcher.register(
            this.dispatch.bind(this))
    }

    getCount() {
        return this._count
    }

    dispatch(payload) {
        const { type, count } = payload.action
        switch (type) {
            case "TICK": this._count = this._count - 1
                this.emit("TICK", this._count)
                return true
            case "RESET": this._count = count
                this.emit("RESET", this._count)
                return true
        }
    }
}

