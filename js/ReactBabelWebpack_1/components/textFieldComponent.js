import React from 'react';
import superagent from 'superagent';
import AutoComplete from './autoComplete'
var timeout;

class TextFieldComponent extends React.Component {
    constructor(props) {
        super(props);

        //this.debounce = this.debounce.bind(this);
        this.searchHelper = this.searchHelper.bind(this);
    }


    searchHelper(e) {


        clearTimeout(timeout);

        timeout = setTimeout(() => {
            console.log(e)
            console.log(window.btoa(e))

            superagent.get(`http://localhost:3033/w?q=${window.btoa(e)}`)
                //.set('Access-Control-Allow-Credentials', 'true')
                //.set('Access-Control-Expose-Headers', 'X-Test-2, X-Test-1')
                //.set('Access-Control-Allow-Origin', 'http://localhost')
                .then(function (res) {
                    console.log(res.body)
                }).catch(function (reason) {
                    console.log(reason)

                })
        }, 3000);
    }

    render() {
        return (
            <div>
                <label>{this.props.label}</label>
                <input type="text" name="search" onInput={function (e) {
                    this.searchHelper( e.target.value)}.bind(this)}
                />


            </div>
        );
    }
}


function debounce(func, wait, immediate) {
    var timeout;

    return function executedFunction() {
        var context = this;
        var args = arguments;

        var later = function () {
            timeout = null;
            if (!immediate) func.apply(context, args);
        };

        var callNow = immediate && !timeout;

        clearTimeout(timeout);

        timeout = setTimeout(later, wait);

        if (callNow) func.apply(context, args);
    };
};

module.exports = TextFieldComponent;