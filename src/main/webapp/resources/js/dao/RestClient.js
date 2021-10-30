class RestClient {

  static myInstance;

  constructor() {
    this.apiUrl = backendApiUrl;
  }

  static getInstance() {
    if (RestClient.myInstance == null) {
      RestClient.myInstance = new RestClient();
    }
    return this.myInstance;
  }

  post(request) {
    const api = request.api;
    const requestBody = request.requestBody;
    const serviceCallback = request.serviceCallback;
    const jwt = request.jwt;
    const multipartRequest = request.multipartRequest;

    let headers = {}
    if (jwt !== undefined) {
      headers = {"Authorization": jwt,};
    }

    if (multipartRequest !== undefined) {
      headers["content-type"] = "multipart/form-data";
    }

    axios.post(this.apiUrl + "/" + api, requestBody, {headers})
        .then(response => {
          // manipulate the response here
          serviceCallback({status: response.status, data: response.data, message: 'success'});
        })
        .catch(error => {
          // manipulate the error response here
          serviceCallback({status: error.response.status, data: {}, message: error.response.data.message});
        });
  }

  get(request) {
    const api = request.api;
    const serviceCallback = request.serviceCallback;
    const jwt = request.jwt;
    let headers = {}
    if (jwt !== undefined) {
      headers = {"Authorization": jwt,};
    }
    axios.get(this.apiUrl + "/" + api, {headers})
        .then(response => {
          // manipulate the response here
          serviceCallback({
            status: response.status,
            data: response.data,
            message: 'success',
            responseObj: response
          });
        })
        .catch(error => {
          // manipulate the error response here
          serviceCallback({status: error.response.status, data: {}, message: error.response.data.message});
        });
  }

  echo() {
    console.log('Rest Client working fine ready to connect with : ' + this.apiUrl);
  }

}