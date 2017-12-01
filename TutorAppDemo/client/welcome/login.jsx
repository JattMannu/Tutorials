import React from 'react';
import ReactDOM from 'react-dom';
import bootstrap from './../css/bootstrap.css'
import pages from './../css/pages.css'


export default class Login extends React.Component {

    constructor(props) {
        super(props);
        this.handleOnFocus = this.handleOnFocus.bind(this)
        this.handleOnChange = this.handleOnChange.bind(this);
        this.state = {
            isUsernameFocused: false,
            ispasswordFocused: false,
            valueUsername: "",
            valuePassword: ""
        };
    }

    handleOnFocus(e) {
        e.preventDefault();
        this.setState({
            isUsernameFocused: e.target.id === 'username' ? true : false,
            ispasswordFocused: e.target.id === 'password' ? true : false
        });
    }

    handleOnChange(e) {
        e.preventDefault();
        this.setState({
            valueUsername: e.target.id === 'username' ? e.target.value : this.state.valueUsername,
            valuePassword: e.target.id === 'password' ? e.target.value : this.state.valuePassword
        });
    }

    render() {
        return (
            <div className="panel-body">
                <form method="POST" action="https://manytutors.com/coordinators/login" acceptCharset="UTF-8">
                    <input name="_token" type="hidden" value="8YXBVa4GMnA3Kk0Ngi602IiSJWnITJjTzjPNMMAI" />
                    <div className="form-group form-group-default">
                        <label htmlFor="username" className={this.state.isUsernameFocused ? "fade" : ""} >Username</label>
                        <input className="form-control" name="username" type="text" value={this.state.valueUsername} id="username" onFocus={this.handleOnFocus} onChange={this.handleOnChange} />
                    </div>
                    <div className="form-group form-group-default">
                        <label htmlFor="password" className={this.state.ispasswordFocused ? "fade" : ""} >Password</label>
                        <input className="form-control" name="password" type="password" value={this.state.valuePassword} id="password" onFocus={this.handleOnFocus} onChange={this.handleOnChange} />
                    </div>
                    <div className="row">
                        <div className="col-sm-6">
                            <a href="https://manytutors.com/coordinators/guest" className="btn btn-lg btn-block">
                                <i className="fa fa-user fa-fw"></i> Login as Guest</a>
                        </div>
                        <div className="col-sm-6">
                            <input className="btn btn-complete btn-lg btn-block" type="submit" value="Login" />
                        </div>
                    </div>
                </form>
            </div >
        );
    }
}
