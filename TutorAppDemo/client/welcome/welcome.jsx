import React from 'react';
import ReactDOM from 'react-dom';
import bootstrap from './../css/bootstrap.css'
import pages from './../css/pages.css'
import LoginHeader from './loginHeader.jsx'
import Info from './info.jsx'
import Header from './header.jsx'

export default class Welcome extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <Header />
                <LoginHeader />
                <Info />
            </div>
        );
    }

}