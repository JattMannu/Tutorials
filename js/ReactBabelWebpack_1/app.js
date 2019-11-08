import React from 'react';
import ReactDOM from 'react-dom';
import ItemTableComponent from './components/itemTableComponent'
import TextFieldComponent from './components/textFieldComponent'

class HelloMessage extends React.Component {
    render() {
        return (
            <div>
                <TextFieldComponent label=""/>
                <ItemTableComponent />
            </div>
        );
    }
}

ReactDOM.render(
    <HelloMessage name="DEMO" />,
    document.getElementById("app")
);