import React from 'react'
import ReactDOM from 'react-dom'

export default class Header extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className="header">
                <div className=" pull-left">
                    <div className="header-inner">
                        <div className="brand inline">
                            <a href="https://manytutors.com/">
                                <img className="header-logo" src="./client/img/logo.png" alt="logo" height="25" />
                            </a>
                        </div>
                    </div>
                </div>
                <div className="pull-right">
                    <div className="navbar-tutor-wrapper">
                        <ul className="list-inline p-t-5">
                            <li>
                                <button className="btn btn-primary btn-sm btn-rounded" data-toggle="modal" data-target="#modalSlideUp">
                                    <i className="fa fa-paypal fa-fw"></i> Coordinator Signup
                            </button>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        );
    }
}