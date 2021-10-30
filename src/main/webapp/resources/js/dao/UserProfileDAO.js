class UserProfileDAO {

  static myInstance;

  static getInstance() {
    if (UserProfileDAO.myInstance == null) {
      UserProfileDAO.myInstance = new UserProfileDAO();
    }

    return this.myInstance;
  }

  profileCompletedTrue() {
    localStorage.setItem('profileCompleted', true);
  }

  profileCompletedFalse() {
    localStorage.setItem('profileCompleted', false);
  }

  getProfileCompletedStatus() {
    return localStorage.getItem('profileCompleted');
  }

  saveProfilePicturePath() {
    localStorage.setItem('profilePicturePath', true);
  }

  getProfilePicturePath() {
    return localStorage.getItem('profilePicturePath');
  }

  saveUserType(userType) {
    localStorage.setItem('userType', userType);
  }

  getUserType() {
    return localStorage.getItem('userType');
  }

  saveUserName(userName) {
    localStorage.setItem('userName', userName);
  }

  getUserName() {
    return localStorage.getItem('userName');
  }

  saveUserResetPassword(userResetPassword) {
    localStorage.setItem("userResetPassword", userResetPassword);
  }

  getUserResetPassword() {
    return localStorage.getItem("userResetPassword");
  }
}