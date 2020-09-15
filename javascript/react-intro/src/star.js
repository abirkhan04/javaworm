import React from 'react';

class Star extends React.Component {
  render() {
    const { selected } = this.props;
    return <div className={(selected) ? "star selected" : "star"} onClick={() => this.props.onClick()}></div>
  }
}


export class StarRating extends React.Component {
  constructor(props) {
    super(props)
    this.state = {
      starsSelected: 0
    }
  }

  change(starsSelected) {
    this.setState({ starsSelected })
  }

  render() {
    const { totalStars, starsSelected } = this.props
    return <div className="star-rating">
      {[...Array(totalStars)].map((n, i) =>
        <Star key={i} selected={i < starsSelected}
          onClick={() => this.change(i + 1)} />
      )}
      <p>{starsSelected} of {totalStars} stars</p>
    </div>
  }

}
