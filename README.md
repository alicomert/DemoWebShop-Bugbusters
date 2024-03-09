# Testing Documentation for DemoWebShop

## Introduction

This project is dedicated to conducting thorough testing of the DemoWebShop website, accessible at [https://demowebshop.tricentis.com](https://demowebshop.tricentis.com). Our goal is to ensure a seamless and error-free user experience by identifying and documenting bugs, errors, and areas for improvement across various user actions and processes within the site.

## Test Environment

**URL:** [https://demowebshop.tricentis.com](https://demowebshop.tricentis.com)

## User Stories and Test Cases

### US_201 Register User
- **Objective:** Verify that new users can successfully register.
- **Test Cases:**
  - Register with valid credentials.
  - Attempt registration with an already used email.

### US_202 Negative | Register User
- **Objective:** Ensure the system properly handles invalid registration attempts.
- **Test Cases:**
  - Register without filling in mandatory fields.
  - Register with an invalid email format.

### US_203 Logout
- **Objective:** Confirm that users can securely log out.
- **Test Case:** Log out after successful login.

### US_204 Login
- **Objective:** Verify login functionality with valid credentials.
- **Test Cases:**
  - Login with correct email and password.
  - Login with case-sensitive email check.

### US_205 Negative | Login
- **Objective:** Ensure the system denies access with invalid credentials.
- **Test Cases:**
  - Login with incorrect password.
  - Login with unregistered email.

### US_206 Ordering
- **Objective:** Test the complete ordering process from product selection to checkout.
- **Test Cases:**
  - Place an order with a registered account.
  - Place an order as a guest.

### US_208 Negative | Using coupons and gift cards
- **Objective:** Verify the system's response to invalid or expired coupons and gift cards.
- **Test Cases:**
  - Apply an expired coupon code.
  - Apply a gift card with insufficient balance.

### US_209 Download the order history to the computer
- **Objective:** Ensure users can download their order history.
- **Test Case:** Download order history from the user profile.

## Contributors

This project is a collaborative effort, with valuable contributions from:

- [Ali Cömert](https://www.github.com/alicomert)
- [Emre Yavuz](https://www.github.com/emreyavvz)
- [Gencer Genç](https://www.github.com/GencerGnc)
- [Medine Özdil](https://www.github.com/mdnozdl)
- [Özgür Karakuş](https://www.github.com/ozgurrkarakus)

## Scenario Guidelines

For each user story, the testing team will follow these steps:

1. **Preparation:** Set up the testing environment and ensure all tools are ready.
2. **Execution:** Follow the steps outlined in the test cases, noting any discrepancies or issues.
3. **Documentation:** Log all findings with screenshots and detailed descriptions.
4. **Review:** The team will review all documented findings to identify patterns or systemic issues.
5. **Feedback:** Submit a report to the development team for review and action.

We aim to cover all critical paths a user might take, including both expected and unexpected behaviors, to ensure the platform is robust and user-friendly.
