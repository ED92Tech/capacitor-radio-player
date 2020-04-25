
  Pod::Spec.new do |s|
    s.name = 'CapacitorRadioPlayer'
    s.version = '0.0.1'
    s.summary = 'Allow you to use the power of native API to control your web radio'
    s.license = 'MIT'
    s.homepage = 'https://github.com/ED92Tech/capacitor-radio-player'
    s.author = 'ED92'
    s.source = { :git => 'https://github.com/ED92Tech/capacitor-radio-player', :tag => s.version.to_s }
    s.source_files = 'ios/Plugin/**/*.{swift,h,m,c,cc,mm,cpp}'
    s.ios.deployment_target  = '11.0'
    s.dependency 'Capacitor'
  end