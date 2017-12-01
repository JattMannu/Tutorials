import React from 'react';
import ReactDOM from 'react-dom';
import Welcome from './client/welcome/welcome.jsx'
import Academic from './client/search/academic.jsx'

class HelloMessage extends React.Component {
    render() {
        return (
            <div>
                Hello {this.props.name}
            </div>
        );
    }
}

ReactDOM.render(
    //<Welcome name="Manpreet" />,
    <Academic name="Manpreet" />,
    document.getElementById("app")
);