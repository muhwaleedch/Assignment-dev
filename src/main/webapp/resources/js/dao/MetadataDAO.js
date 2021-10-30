class MetadataDAO {

  static myInstance;

  static getInstance() {
    if (MetadataDAO.myInstance == null) {
      MetadataDAO.myInstance = new MetadataDAO();
    }

    return this.myInstance;
  }

  saveCountries(countries) {
    localStorage.setItem('countries', JSON.stringify(countries));
  }

  getCountries() {
    return JSON.parse(localStorage.getItem('countries'));
  }

  saveCities(cities) {
    localStorage.setItem('cities', JSON.stringify(cities));
  }

  getCities() {
    return JSON.parse(localStorage.getItem('cities'));
  }

  saveStates(states) {
    localStorage.setItem('states', JSON.stringify(states));
  }

  getStates() {
    return JSON.parse(localStorage.getItem('states'));
  }

  saveAddressTypes(addressTypes) {
    localStorage.setItem('addressTypes', JSON.stringify(addressTypes));
  }

  getAddressTypes() {
    return JSON.parse(localStorage.getItem('addressTypes'));
  }

  saveMenuItemTypes(menuItemTypes) {
    localStorage.setItem('menuItemTypes', JSON.stringify(menuItemTypes));
  }

  getMenuItemTypes() {
    return JSON.parse(localStorage.getItem('menuItemTypes'));
  }
}