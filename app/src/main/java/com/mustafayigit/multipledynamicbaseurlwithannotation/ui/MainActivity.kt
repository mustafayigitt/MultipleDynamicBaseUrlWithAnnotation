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

            initSpinner(spinnerAuth, items)
            initSpinner(spinnerContent, items)
            initSpinner(spinnerPayment, items)
        }
    }

    private fun initSpinner(spinner: Spinner, items: List<String>) {
        with(mBinding) {
            spinner.adapter = ArrayAdapter(
                this@MainActivity,
                android.R.layout.simple_spinner_dropdown_item,
                items
            )

            val apiType = getApiTypeBySpinner(spinner)
            val selectedDeploymentType = getDeploymentType(apiType)
            spinner.setSelection(items.indexOf(selectedDeploymentType.name.lowercase()))

            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val newDeploymentType = DeploymentType.values()[position]
                    updateEnvironment(apiType, newDeploymentType)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

            }
        }
    }

    private fun getApiTypeBySpinner(spinner: Spinner): ApiType {
        return when (spinner) {
            mBinding.spinnerAuth -> ApiType.AUTH
            mBinding.spinnerContent -> ApiType.CONTENT
            mBinding.spinnerPayment -> ApiType.PAYMENT
            else -> throw IllegalArgumentException("Invalid spinner")
        }
    }

    private fun getDeploymentType(apiType: ApiType): DeploymentType {
        return EnvironmentManager.environments.find { it.apiType == apiType }?.deploymentType
            ?: throw IllegalArgumentException("Invalid api type")
    }

    private fun updateEnvironment(
        apiType: ApiType,
        deploymentType: DeploymentType
    ) {
        val index =
            EnvironmentManager.environments.indexOfFirst { it.apiType == apiType }
        EnvironmentManager.environments[index] = EnvironmentModel(
            apiType = apiType,
            deploymentType = deploymentType
        )
    }


}