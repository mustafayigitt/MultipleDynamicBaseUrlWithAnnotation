package com.mustafayigit.multipledynamicbaseurlwithannotation.ui

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.mustafayigit.multipledynamicbaseurlwithannotation.data.model.EnvironmentModel
import com.mustafayigit.multipledynamicbaseurlwithannotation.databinding.ActivityMainBinding
import com.mustafayigit.multipledynamicbaseurlwithannotation.enums.ApiType
import com.mustafayigit.multipledynamicbaseurlwithannotation.enums.DeploymentType
import com.mustafayigit.multipledynamicbaseurlwithannotation.manager.EnvironmentManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val mViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)

        initListeners()
        initSpinners()

    }

    private fun initListeners() {
        with(mBinding) {

            btnLogin.setOnClickListener {
                mViewModel.login("mustafa", "1234")
            }

            btnGetContents.setOnClickListener {
                mViewModel.getContents()
            }

            btnPayment.setOnClickListener {
                mViewModel.pay()
            }

        }
    }

    private fun initSpinners() {
        with(mBinding) {
            val items = DeploymentType.values().map { it.name.lowercase() }

            initSpinner(spinnerAuth, items, ApiType.AUTH)
            initSpinner(spinnerContent, items, ApiType.CONTENT)
            initSpinner(spinnerPayment, items, ApiType.PAYMENT)
        }
    }

    private fun initSpinner(spinner: Spinner, items: List<String>, selected: ApiType) {
        with(mBinding) {
            spinner.adapter = ArrayAdapter(
                this@MainActivity,
                android.R.layout.simple_spinner_dropdown_item,
                items
            )

            val selectedDeploymentType = EnvironmentManager.environments.find { it.apiType == selected }!!.deploymentType
            spinner.setSelection(items.indexOf(selectedDeploymentType.name.lowercase()))
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val apiType = when (spinner) {
                        spinnerAuth -> ApiType.AUTH
                        spinnerContent -> ApiType.CONTENT
                        spinnerPayment -> ApiType.PAYMENT
                        else -> ApiType.AUTH
                    }
                    val index =
                        EnvironmentManager.environments.indexOfFirst { it.apiType == apiType }
                    EnvironmentManager.environments[index] = EnvironmentModel(
                        apiType = apiType,
                        deploymentType = DeploymentType.values()[position]
                    )
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

            }
        }
    }

}