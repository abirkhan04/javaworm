import { StarRating } from './star'
import React from 'react'
import { of } from 'rxjs';
import './index.css'

export const colors = () => of([
    {
        id: "1",
        title: "First Title",
        color: "#00c4e2",
        rating: 4,
    },
    {
        id: "2",
        title: "Second title",
        color: "#0064e2",
        rating: 5,
    }
]);


export class App extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            colors: []
        }
    }

    render() {
        const { colors } = this.props
        return <div className="app">
            <ColorList colors={colors} />
        </div>
    }
}

class ColorList extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            colors: []
        }
    }

    componentWillMount() {
        this.state.colors = this.props.colors
    }

    componentDidMount() {
         colors().subscribe((colors)=>{
             this.setState({colors:colors})
         })
    }

    render() {
        const { colors } = this.state
        return <div className="color-list">
            {(colors.length === 0) ? <p> No colors Listed. Add a color</p> : colors.map((color) =>
                <Color key={color.id} {...color} />
            )}
        </div>
    }
}

class Color extends React.Component {
    constructor(props) {
        super(props)
    }

    componentWillMount() {
        this.style = {
            backgroundColor: "#CCC"
        }
    }

    componentWillUpdate() {
        this.style = null
    }

    render() {
        const totalStars = 5;
        const { title, color, rating = 0 } = this.props;
        return <section className="color" style={this.style}>
            <h1>{title}</h1>
            <div style={{ backgroundColor: color }}>{title}</div>
            <div><StarRating starsSelected={rating} totalStars={totalStars} /></div>
        </section>
    }
}
