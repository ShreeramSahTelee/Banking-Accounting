import React from "react";



const TransferFund = () => {
  return (
    <>
      <div className="row p-2">
        <p class="text-center fs-1" id="adminHead">Online Transactions</p>
        <div class="col-md-7 cardx">
          <a class="text-decoration-none bg-custom">
            <div class="card paint-card">
              <div class="card-body text-left">
                <i class="bi bi-journal-check fa-2x"></i>
                <br />
                <p class="fs-3 text-dark">Current Balance is :</p>
                <p class="fs-3 text-dark"></p>
              </div>
            </div>
          </a>
        </div>
        {/* <div class="col-md-6">
          <a class="text-decoration-none bg-custom">
            <button type="button" class="btn btn-primary btn-lg btn-block">Deposit Fund</button><br></br><br></br>
            <button type="button" class="btn btn-primary btn-lg btn-block">Transfer Fund</button>
          </a>
        </div> */}
      </div>
      {/* Deposit And transactions start here */}
      <p className="text-danger ">All fields are required...</p>
      <form class="row g-3 border border-dark"  >
        <div class="col-md-6 ">
          <label class="form-label">Customer ID</label>
          <input type="number" placeholder="Enter Customer ID" class="form-control" required />
        </div>
        <div class="col-md-4">
          <label class="form-label">Transaction Type</label>
          <select class="form-select" required>
            
            <option value="Cash Deposit">Cash Deposit</option>
            <option value="Fund Transfer">Fund Transfer</option>
          </select>
        </div>
        <div class="col-md-2">
          <label class="form-label">Transaction Nature</label>
          <select class="form-select" required>
            
            <option value="Cash Deposit">Credit</option>
            <option value="Fund Transfer">Debit</option>
          </select>
        </div>
        <div class="col-md-6">
          <label class="form-label">Amount(Rs.)</label>
          <input type="number" min={1} placeholder="Enter Amount" class="form-control" required/>
        </div>
        <div class="col-md-6">
          <label class="form-label"> Account Number</label>
          <input type="number" placeholder="Enter Beneficieary Account Number" class="form-control" required />
          
        </div>
     
      <div className="row mt-3">
          <div className="col">
            <label class="form-label">Narration </label>
            <textarea maxLength={40}
              required
              rows="3"
              cols="2"
              placeholder="Leave message here..."
              className="form-control"
              name="narration"

            ></textarea><br></br>
          </div>
        </div>
        </form>
        <div className="row mt-3">
        <div className="col">
          <button type="submit" class="btn btn-success btn-mg me-md-3">Submit </button>
          <button type="cancel" class="btn btn-danger btn-mg ">Cancel </button>
        </div>
      </div>
    </>
  )
}
export default TransferFund;