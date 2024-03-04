import {Component} from "react";

class DemoState extends Component {
    constructor() {
        super();
        this.state = {
            number: 0
        }
    }

    increment = () => {
        // this.setState({number: this.state.number + 1})
        // console.log(this.state.number)
        // this.setState({number: this.state.number + 1})
        // console.log(this.state.number)
        // this.setState({number: this.state.number + 1})
        // console.log(this.state.number)
        this.setState(prev => {
            return {
                number: prev.number + 1
            }
        })
        console.log(this.state.number)
        this.setState(prev => {
            return {
                number: prev.number + 1
            }
        })
        console.log(this.state.number)
        this.setState(prev => {
            return {
                number: prev.number + 1
            }
        })
        console.log(this.state.number)
    }

    render() {
        return (
            <>
                <h2>{this.state.number}</h2>
                <button onClick={this.increment}>Increment</button>
            </>
        )
    }
}

export default DemoState;