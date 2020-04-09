// The Auth0 client, initialized in configureClient()
let auth0 = null;

const printMessage = (msg) => {
    document.getElementById("json").textContent = JSON.stringify(msg, undefined, 4);
}

const login = async (targetUrl) => {
    try {
        console.log("Logging in", targetUrl);

        const options = {
            redirect_uri: window.location.origin
        };
        console.log("options.redirect_uri", options.redirect_uri)

        if (targetUrl) {
            options.appState = { targetUrl };
        }

        const resp = await auth0.loginWithRedirect(options);
    } catch (err) {
        console.log("Log in failed", err);
    }
};

const logout = () => {
    try {
        console.log("Logging out");
        auth0.logout({
            returnTo: window.location.origin
        });
    } catch (err) {
        console.log("Log out failed", err);
    }
};


const configureClient = async () => {
    auth0 = await createAuth0Client({
        domain: "dev-autho-1.auth0.com",
        client_id: "mGucyv4AOfmfX1mRUYSoCLEymk0ubsA6",
        audience: "https://quickstarts/api"
    });
};

const isAuthenticated = async () => {
    const isAuthenticated = await auth0.isAuthenticated();
    console.log("isAuthenticated : ", isAuthenticated)

    printMessage({isAuthenticated});
};



const getToken = async () => {
    try {
        const token = await auth0.getTokenSilently();
        console.log(token)
        let decoded = jwt_decode(token);
        // console.log(decoded);
        printMessage({token,decoded});
     
    } catch (e) {
        console.error(e);
    }
};


const getUserProfile = async () => {
    try {
        const user = await auth0.getUser();
        console.log(user)
        printMessage({user});
    } catch (e) {
        console.error(e);
    }
};


window.onload = async () => {
    console.log("On Page load")
    await configureClient();


    const query = window.location.search;
    const shouldParseResult = query.includes("code=") && query.includes("state=");

    if (shouldParseResult) {
        console.log("> Parsing redirect");
        try {
            const result = await auth0.handleRedirectCallback();
            window.history.replaceState({}, document.title, "/");
        } catch (err) {
            console.log("Error parsing redirect:", err);
        }
    };


};

// login("http://127.0.0.1:8887/")