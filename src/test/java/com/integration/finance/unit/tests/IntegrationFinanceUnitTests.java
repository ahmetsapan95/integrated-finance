package com.integration.finance.unit.tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.integrated.finance.utility.UtilityFunctions;



public class IntegrationFinanceUnitTests {

	@Test
	public void testAmountChar() {
		
		String response = UtilityFunctions.checkAmountFormat("abc");
		assertEquals("Invalid Transaction Amount",response);
	}
	
	@Test
	public void testAmountNegative() {
		
		String response = UtilityFunctions.checkAmountFormat("-5");
		assertEquals("Transaction amount cannot be negative.",response);
	}
	
	@Test
	public void testAmountTrue() {
		
		String response = UtilityFunctions.checkAmountFormat("5.66");
		assertEquals("5.66",response);
	}
	
	@Test
	public void testAmountConvert() {
		
		String response = UtilityFunctions.prepareConvertExchangeAmount(1.0, 2.0, "5.0");
		assertEquals("10.00000",response);
	}

}


//Tried some integration testing.

//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//public class BestRestApiEverApplicationTests {
//
//	private MockMvc mockMvc;
//
//	@InjectMocks
//	private ExchangeApiController exchangeApiController;
//
//	@MockBean
//	LiveResponseService liveResponceService;
//
//	@Autowired
//	private WebApplicationContext wac;
//
//	@Before
//	public void setup() throws Exception {
//		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
//		this.mockMvc = builder.build();
//	}
//
//	@Test
//	public void testExchangeRateApi() throws Exception {
//		ResponseEntity<ResponseModel> responseEntity = liveResponceService.sendLiveRequest("USDGBP");
//		when(liveResponceService.sendLiveRequest("USDGBP")).thenReturn(responseEntity);
//
//		ExchangeRateModel exchangeRateModel = new ExchangeRateModel();
//		exchangeRateModel.setSource("USD");
//		exchangeRateModel.setTarget("GBP");
//		Gson gson = new Gson();
//		String json = gson.toJson(exchangeRateModel);
//
//		mockMvc.perform(post("/exchange-rate").contentType(MediaType.APPLICATION_JSON).content(json)
//				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//				.andExpect(jsonPath("$.response").value("5"));
//	}

